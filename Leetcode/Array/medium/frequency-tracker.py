class FrequencyTracker:
    freq_map = None
    inverse_freq = None

    def __init__(self):
        self.freq_map = dict()
        self.inverse_freq = dict()

    # check if freq_map has a entry for this new number
    # if yes, increment the freq and remove the number from old inverse map key and insert into new inverse map key
    # else, add the number into both the hash maps
    
    # Time - O(1)
    def add(self, number: int) -> None:
        
        if number in self.freq_map:
            old_freq = self.freq_map[number]
            self.inverse_freq[old_freq].remove(number)
            if old_freq + 1 in self.inverse_freq and len(self.inverse_freq[old_freq + 1]) > 0:
                self.inverse_freq[old_freq + 1].add(number)
            else:
                self.inverse_freq[old_freq + 1] = {number}

            self.freq_map[number] = old_freq + 1
        
        else:
            self.freq_map[number] = 1
            if 1 in self.inverse_freq and len(self.inverse_freq[1]) > 0:
                self.inverse_freq[1].add(number)
            else:
                self.inverse_freq[1] = {number}

        # print("type add")
        # print("number ", number)
        # print("freq_map ", self.freq_map)
        # print("inverse ", self.inverse_freq)


    # check if freq_map has entry for this number and it has a non-zero frequency
    # if yes, decrement the freq and remove the number from old inverse map key and insert into new inverse map key
    
    # Time - O(1)
    def deleteOne(self, number: int) -> None:
        # print("type del")
        # print("number ", number)
        # print("freq_map ", self.freq_map)
        # print("inverse ", self.inverse_freq)

        if number in self.freq_map and self.freq_map[number] > 0:
            old_freq = self.freq_map[number]
            self.inverse_freq[old_freq].remove(number)

            if old_freq > 0:
                if old_freq - 1 in self.inverse_freq and len(self.inverse_freq[old_freq - 1]) > 0:
                    self.inverse_freq[old_freq - 1].add(number)
                else:
                    self.inverse_freq[old_freq - 1] = {number}

            self.freq_map[number] = old_freq - 1
            

    # Time - O(1)
    def hasFrequency(self, frequency: int) -> bool:
        return frequency in self.inverse_freq and len(self.inverse_freq[frequency]) > 0


# Your FrequencyTracker object will be instantiated and called as such:
# obj = FrequencyTracker()
# obj.add(number)
# obj.deleteOne(number)
# param_3 = obj.hasFrequency(frequency)