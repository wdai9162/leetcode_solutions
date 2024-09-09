#!/bin/bash

# Update the package list and upgrade the system
sudo apt update && sudo apt upgrade -y

# 1. Install and start SSH server
echo "Installing and starting SSH server..."
sudo apt install -y openssh-server
sudo systemctl enable ssh
sudo systemctl start ssh

# 2. Disable root password login
echo "Disabling root password login in SSH..."
sudo sed -i 's/#PermitRootLogin yes/PermitRootLogin prohibit-password/' /etc/ssh/sshd_config
sudo systemctl reload ssh

# 3. Set up SSH Public Key Authentication
echo "Enabling SSH Public Key Authentication..."
sudo sed -i 's/#PubkeyAuthentication yes/PubkeyAuthentication yes/' /etc/ssh/sshd_config

# Add the SSH public key to the authorized_keys file
echo "Adding your SSH public key..."
SSH_DIR="/home/$USER/.ssh"
AUTH_KEYS="$SSH_DIR/authorized_keys"

# Create .ssh directory and authorized_keys file if they don't exist
mkdir -p "$SSH_DIR"
chmod 700 "$SSH_DIR"

# Replace <place-holder> with your actual public key in the next line
echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCenw/spqdhWlwqsSCe/AxJu3z8bP3jSRz18wVmSjJnbH14OJfNocqAMBplGb8PRSvKHYzGbEf8HOpi8m9vBHM8drjjoM46B54qbavDJYpQVrBg6XuQlZsMv1ZpfHgUkGwifN2o1cSh7f6GB5qyVZHQEPLMGSevM90XOwDaPoguBkp3Z1pWqJC2t8AWt5K9mA8vVjxVT4pfo59YXD2CAxXRXl1fGG4kAFxT+6wPQCUhLKleHHm4UrqPGAhkMIFLgg49v3EQvTumayGa07qdQ7IyhkAK8Aj1Ot4vX7RDjcQmPgJHqyY2RKWSrM/IH4PzM4Rwft/GDWQWh26a0GuE4QqV 100005095@qq.com" >> "$AUTH_KEYS"
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

# 7. Install common tools
echo "Installing common tools like dig, netstat, ps..."
sudo apt install -y dnsutils net-tools procps htop wget

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
