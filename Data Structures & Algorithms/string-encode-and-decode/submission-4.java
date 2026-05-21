class Solution {

    public String encode(List<String> strs) {
        // the thing is, if we want to decode, we must know how to seperate them for a long string.
        // remember their sizes is a good way to do, and put size at the begin of each string
        // but there might be digits in the string itself so we use a specific character after size to
        // indicate that the size is exactly the size
        // for abcde, it should be encoded as 5#abcde
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            // encode and append
            sb.append(str.length()).append('#').append(str);
        }
        // return to string
        return sb.toString();
    }

    public List<String> decode(String str) {
        // substract substring from the long string
        List<String> res = new ArrayList<>();
        // we walk through the string, if we get the first #, that means
        // we found the first size of the substring;
        // then we put it in the res;
        // then we keep going until the next #, and put it in the res
        int start = 0;
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) == '#'){
                // we have to remember the end of last string
                // and read the size between it and #
                int size = Integer.parseInt(str.substring(start, i));
                String s = str.substring(i + 1, i + size + 1);
                res.add(s);
                start = i + size + 1;
                i = start - 1;
            }
        }
        return res;

    }
}
