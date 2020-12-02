package unionfind;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Baitao Zou
 * date 2020/12/02
 */
public class AccountsMerge721Test extends TestCase {

    private AccountsMerge721 merge = new AccountsMerge721();

    public void test1() {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.stream(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"John", "johnnybravo@mail.com"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"Mary", "mary@mail.com"}).collect(Collectors.toList()));

        List<List<String>> result = merge.accountsMerge(accounts);
        print(result);
    }

    public void test2() {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.stream(new String[]{"Lily", "Lily3@m.co", "Lily4@m.co", "Lily17@m.co"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"Lily", "Lily5@m.co", "Lily3@m.co", "Lily23@m.co"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"Lily", "Lily0@m.co", "Lily1@m.co", "Lily8@m.co"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"Lily", "Lily14@m.co", "Lily23@m.co"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"Lily", "Lily4@m.co", "Lily5@m.co", "Lily20@m.co"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"Lily", "Lily1@m.co", "Lily2@m.co", "Lily11@m.co"}).collect(Collectors.toList()));
        accounts.add(Arrays.stream(new String[]{"Lily", "Lily2@m.co", "Lily0@m.co", "Lily14@m.co"}).collect(Collectors.toList()));
        List<List<String>> result = merge.accountsMerge(accounts);
        print(result);
    }

    private void print(List<List<String>> result) {
        for (List<String> account : result) {
            System.out.println(account.toString());
        }
    }
}
