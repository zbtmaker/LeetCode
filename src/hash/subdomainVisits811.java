package hash;

import java.util.*;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class subdomainVisits811 {
    public static void main(String[] args){

        List<String> list = new subdomainVisits811().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(Arrays.toString(list.toArray()));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<String>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0;i<cpdomains.length;i++){
            String[] domains = cpdomains[i].split(" ");
            int num = Integer.parseInt(domains[0]);
            subdomainVisits(domains[1],num,map);
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            list.add(entry.getValue()+" "+entry.getKey());
        }

        return list;
    }
    private void subdomainVisits(String domain,int num,Map<String,Integer> map) {
        if (map.containsKey(domain)) {
            map.put(domain, map.get(domain) + num);
        } else {
            map.put(domain, num);
        }
        int i = 0;
        while(i<domain.length()){
            if(domain.charAt(i) == '.'){
                subdomainVisits(domain.substring(i+1),num,map);
                break;
            }else{
                i ++;
            }
        }
    }
}
