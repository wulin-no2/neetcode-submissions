class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while( i < str.length()){
            // find the length of str 
            int j = i;
            while(str.charAt(j) !='#') j++;
            int length = Integer.parseInt(str.substring(i, j));
            // get string of given length
            String word = str.substring(j + 1, j + length + 1);
            res.add(word);
            // move i
            i = j + length + 1;
        }
        return res;

    }
}
