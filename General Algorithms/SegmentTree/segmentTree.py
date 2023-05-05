import math

inputArr = [-1,2,4,0]
segLen = 4*len(inputArr)
segTree = [math.inf]*segLen

def constructTree(low, high, pos):
  if low == high:
    # print(segTree, pos, low)
    segTree[pos] = inputArr[low]
    return
  mid = (low + high)//2

  constructTree(low, mid, 2*pos+1)
  constructTree(mid+1, high, 2*pos+2)

  segTree[pos] = min(segTree[2*pos+1], segTree[2*pos+2])


def rangeMinQuery(qlow, qhigh, low, high, pos):
  if qlow <= low and qhigh >= high:
    return segTree[pos]
  if qlow > high or qhigh < low:
    return math.inf

  mid = (low + high)//2

  return min(rangeMinQuery(qlow, qhigh, low, mid, 2*pos+1),
             rangeMinQuery(qlow, qhigh, mid+1, high, 2*pos+2))

# i - update ith index to "val"
def update(low, high, pos, i, val):
  if low == high:
    # print(segTree, pos, low)
    segTree[pos] = val
    return
  mid = (low + high)//2

  if i > mid:
    update(mid+1, high, 2*pos+2, i, val)
  else:
    update(low, mid, 2*pos+1, i, val)
  

  segTree[pos] = min(segTree[2*pos+1], segTree[2*pos+2])

if __name__ == '__main__':
  
  # segTree len = 2*n - 1
  # segLen = 1
  # while segLen <= len(inputArr):
  #   segLen *= 2
  # segLen -= 1
  
  constructTree(0, len(inputArr)-1, 0)
  print(segTree)
  update(0, len(inputArr)-1, 0, 1, -2)
  print(segTree)
  print(rangeMinQuery(0, 2, 0, len(inputArr)-1, 0))
