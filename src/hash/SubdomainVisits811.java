package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class SubdomainVisits811 {
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
