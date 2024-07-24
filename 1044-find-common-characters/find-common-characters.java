class Solution {
    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        int commonCh[] = new int [26];
        Arrays.fill(commonCh,Integer.MAX_VALUE);

        for(String str : words)
        {
            int ch[] = new int[26];
            for(int i=0;i<str.length();i++)
            {
                ch[str.charAt(i)-'a']++;
            }

            for(int i=0;i<26;i++)
            {
                commonCh[i] = Math.min(commonCh[i],ch[i]);
            }


        }

        for(int i=0;i<26;i++)
        {
            while(commonCh[i]>0)
            {
                list.add(String.valueOf((char)(i+'a')));
                commonCh[i]--;
            }
        }
        return list;
            
        
    }
}