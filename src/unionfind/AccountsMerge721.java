package unionfind;

import java.util.*;

/**
 * @author Baitao Zou
 * date 2020/12/01
 */
public class AccountsMerge721 {
    /**
     * 采用Union Find方式，其中每一个email的根节点就是List数组的index为止，同时我们用一个HashMap来记录每一个email第一次出现的点，如果再次出现的时候，我们就需要进行union操作
     * 注意点：同一个list中可能存在相同的email地址，所以我选择合并之前的去重操作。
     *
     * @param accounts 账号
     * @return 合并后的账号
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mailMapIndex = new HashMap<>();
        int len = accounts.size();
        int[] id = initId(len);
        int[] size = new int[len];
        Arrays.fill(size, 1);
        for (int i = 0; i < len; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String mail = account.get(j);
                if (mailMapIndex.containsKey(mail) && mailMapIndex.get(mail) != i) {
                    union(mailMapIndex.get(mail), i, id, size);
                } else {
                    mailMapIndex.put(mail, i);
                }
            }
        }

        //寻找根节点、将其他节点合并到根节点
        List<Integer> root = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (i == id[i]) {
                root.add(i);
            } else {
                int parent = parent(i, id);
                accounts.get(parent).addAll(accounts.get(i));
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (Integer i : root) {
            Set<String> set = new HashSet<>(accounts.get(i));
            List<String> list = new ArrayList<>(set);
            list.sort(String::compareTo);
            result.add(list);
        }
        return result;
    }

    private int[] initId(int size) {
        int[] id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
        return id;
    }

    private int parent(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    private void union(int p, int q, int[] id, int[] size) {
        int pId = parent(p, id);
        int qId = parent(q, id);
        if (pId == qId) {
            return;
        }
        if (size[pId] >= size[qId]) {
            id[qId] = pId;
            size[pId] += size[qId];
        } else {
            id[pId] = qId;
            size[qId] += size[pId];
        }
    }
}
