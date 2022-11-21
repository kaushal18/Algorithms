import math

def constructTree(inputArr, segTree, low, high, pos):
  if low == high:
    # print(segTree, pos, low)
    segTree[pos] = inputArr[low]
    return
  mid = (low + high)//2

  constructTree(inputArr, segTree, low, mid, 2*pos+1)
  constructTree(inputArr, segTree, mid+1, high, 2*pos+2)

  segTree[pos] = min(segTree[2*pos+1], segTree[2*pos+2])


def rangeMinQuery(segTree, qlow, qhigh, low, high, pos):
  if qlow <= low and qhigh >= high:
    return segTree[pos]
  if qlow > high or qhigh < low:
    return math.inf

  mid = (low + high)//2

  return min(rangeMinQuery(segTree, qlow, qhigh, low, mid, 2*pos+1),
             rangeMinQuery(segTree, qlow, qhigh, mid+1, high, 2*pos+2))

if __name__ == '__main__':
  inputArr = [-1,2,4,0]
  # segTree len = 2*n - 1
  segLen = 1
  while segLen <= len(inputArr):
    segLen *= 2
  segLen -= 1

  segTree = [math.inf]*segLen
  constructTree(inputArr, segTree, 0, len(inputArr)-1, 0)
  print(segTree)

  print(rangeMinQuery(segTree, 0, 2, 0, len(inputArr)-1, 0))
