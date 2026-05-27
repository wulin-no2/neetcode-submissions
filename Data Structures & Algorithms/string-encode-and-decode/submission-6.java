class Solution {

    public String encode(List<String> strs) {
        // we need seperators for them so we can decode
        // they contain 156 characters so no special characters should be used only
        // we use the length of strings and a special character after it as the start of each string
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        //find the first '#' and then we know the length and the first string;
        // keep looking the '#' from next string
        List<String> res = new ArrayList<>();
        int start = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i)=='#'){
                //found a str
                int len = Integer.parseInt(str.substring(start, i));
                String s = str.substring(i + 1, i + len + 1);
                res.add(s);
                start = i + len + 1;
                i = start;
            } 
        }
        return res;

    }
}
