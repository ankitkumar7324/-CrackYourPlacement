class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            String temp = words[i];
            for(int j=0;j<n;j++){
                String temp2 = words[j];
                if(temp2.contains(temp)==true && !temp.equals(temp2)){
                    ans.add(temp);
                    break;
                }
            }
        }
        return ans;
    }
}