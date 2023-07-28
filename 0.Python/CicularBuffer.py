from collections import deque
from queue import Queue

class CircularBuffer(deque):
    
    def __init__(self, size): 
        super().__init__(maxlen=size)
    
    def putend(self, item):
        self.append(item)
    
    def putstart(self, item):
        self.appendleft()
    
    def get(self):
        return self.popleft()
        
q = Queue(maxsize=3)
q.put('1')
q.put('2')
q.put('3')

try: 
    q.put('4', block=True, timeout=10)
except Exception as e:
    print("Timeout! Queue is full and no space became available within the timeout period.")

# Get an item from the queue
print(q.get())  # "element1"

# Now we can add another item without blocking
q.put("4")