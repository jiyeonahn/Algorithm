package Level1;

public static long solution(long n) {
        String numString = String.valueOf(n);//"118372"

        char[] a = new char[numString.length()];//[1,1,8,3,7,2]
        for(int i = 0;i < numString.length(); i++){
        a[i] = numString.charAt(i);
        }

        Arrays.sort(a);
        StringBuffer sb = new StringBuffer();
        for(int i = a.length - 1; i >= 0; i--)
        sb.append(a[i]);
        return Long.parseLong(sb.toString());
        }
