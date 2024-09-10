#!/bin/bash

# Define the log file
LOG_FILE="/tmp/bootstrap.log"

# Redirect all output and errors to the log file
exec > >(tee -a $LOG_FILE) 2>&1

echo "Starting the bootstrap script..."

# Update the package list and upgrade the system
echo "Updating and upgrading the system..."
sudo apt update && sudo apt upgrade -y

# 1. Install and start SSH server
echo "Installing and starting SSH server..."
sudo apt install -y openssh-server
sudo systemctl enable ssh
sudo systemctl start ssh

# 2. Disable root password login
echo "Disabling root password login in SSH..."
sudo sed -i 's/#PasswordAuthentication yes/PasswordAuthentication no/' /etc/ssh/sshd_config
sudo sed -i 's/PasswordAuthentication yes/PasswordAuthentication no/' /etc/ssh/sshd_config
sudo sed -i 's/#PermitRootLogin yes/PermitRootLogin prohibit-password/' /etc/ssh/sshd_config
sudo systemctl reload ssh

# 3. Set up SSH Public Key Authentication
echo "Enabling SSH Public Key Authentication..."
sudo sed -i 's/#PubkeyAuthentication yes/PubkeyAuthentication yes/' /etc/ssh/sshd_config

# Determine home directory
if [ "$USER" == "root" ]; then
    SSH_DIR="/root/.ssh"
else
    SSH_DIR="/home/$USER/.ssh"
fi
AUTH_KEYS="$SSH_DIR/authorized_keys"

# Add the SSH public key to the authorized_keys file
echo "Adding your SSH public key..."
mkdir -p "$SSH_DIR"
chmod 700 "$SSH_DIR"

# Replace <place-holder> with your actual public key in the next line
echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQCohOFaXQdrD7ZuUHO3mu37fksrJhjA4A8ukdsTT0nRkAlrGv+iplpZnDMxwa9mRT/w1btVM6/BFMQ4rpB9W5ukbqwKM4r04JqR2J64eIfz7xy5kW+EaquwjYvZJq9SA03R6LtBFJ9ZQW+SbHoIhfTkKbqSYlhyJIC8oWZqvkdIPudGZnGuLesDBIyQtuXujT0Q6MRCPAXzQkzAOJYiYkm6ffU9NUJwN6+ZkAzLJEwiO054Q8jxs9sHti8ih0mK8p+BPV+bMaNbu34ZkutkBF9T5FySaGsQywaq9XYa0hMIq7wF7bUw7Zt1wBttCeSRvjpao8kF1NNtmoKYeg2StV9+ya2ZVOjgw36oYCJZd0h1u6eE10NXl9o2K2sUWMMAkZkJsbY8wKTqnO4OrpISNZRYKp3QwsYPmRFNvvBbkJxJ7ybrhYEpoV5baBZMeXIcJ4WkPrIYBymf9QWcoWOB/arffqCuSRPQ8FGOxUWfgmjnD5HsCFmHZiabt6CLKqzjXvs1SD/74Sqey02VrVVgScrp7/yNiE7wNH0XTjKvQLqBULgyptaL82n+SVnVy1LeR1Xzak1++am4J4d9xHIoy5UwbShhHQCcfarvtk/VvQJMtYcxzeKN/ripv/gyBNdcuHg/yZG97v+Iiy/w2Rb8kr5P6RI7TVGTBsXNALLWnmoBJw== wdai9162@gmail.com" >> "$AUTH_KEYS"
chmod 600 "$AUTH_KEYS"

# Ensure the correct ownership for the .ssh directory and authorized_keys file
sudo chown -R $USER:$USER "$SSH_DIR"

# Reload the SSH service to apply changes
sudo systemctl reload ssh

# 4. Install Zsh and set it as the default shell
echo "Installing Zsh..."
sudo apt install -y zsh
echo "Changing default shell to Zsh for user $USER..."
chsh -s $(which zsh)

# 5. Install Oh My Zsh
echo "Installing Oh My Zsh..."
if [ ! -d "$HOME/.oh-my-zsh" ]; then
  sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
else
  echo "Oh My Zsh is already installed."
fi

# 6. Check and install the necessary packages
echo "Installing necessary packages..."
sudo apt install -y git python3-dev libffi-dev gcc libssl-dev python3-venv

# 7. Install common tools like dig, netstat, ps, lshw, lsof
echo "Installing common tools like dig, netstat, ps, lshw, lsof..."
sudo apt install -y dnsutils net-tools procps lshw lsof

# 8. Ensure Docker is installed and running
if ! command -v docker &> /dev/null; then
    echo "Docker not found, installing Docker..."
    sudo apt install -y apt-transport-https ca-certificates curl gnupg lsb-release
    curl -fsSL https://download.docker.com/linux/debian/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
    echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/debian $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
    sudo apt update
    sudo apt install -y docker-ce docker-ce-cli containerd.io
    sudo systemctl enable docker
    sudo systemctl start docker
else
    echo "Docker is already installed."
    sudo systemctl start docker
fi

# Verify that Docker is running
if sudo systemctl is-active --quiet docker; then
    echo "Docker is running."
else
    echo "Docker failed to start."
fi

echo "Configuration is complete!"
