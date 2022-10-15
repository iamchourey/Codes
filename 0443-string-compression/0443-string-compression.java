class Solution {
    public int compress(char[] chars) {
        int count=1,result=0,index=0;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]) count++;
            else{
                chars[index++]=chars[i-1];
                if(count>1){
                    if(count<10){
                        chars[index++]=(char)(count+'0');
                        result+=2;
                    }
                    else{
                        Stack<Integer> stack=new Stack<>();
                        while(count>0){
                            stack.push(count%10);
                            count/=10;
                        }
                        result+=stack.size()+1;
                        while(stack.isEmpty()==false) chars[index++]=(char)(stack.pop()+'0');
                    }
                }
                else result++;
                count=1;
            }
        }
        chars[index++]=chars[chars.length-1];
        if(count>1){
            if(count<10){
                        chars[index++]=(char)(count+'0');
                        result+=2;
                    }
                    else{
                        Stack<Integer> stack=new Stack<>();
                        while(count>0){
                            stack.push(count%10);
                            count/=10;
                        }
                        result+=stack.size()+1;
                        while(stack.isEmpty()==false) chars[index++]=(char)(stack.pop()+'0');
                    }
        }
        else result++;
        return result;
    }
}