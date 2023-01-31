package hot;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName: NumUniqueEmails929
 * author: gxs
 * Date: 2021/11/16  17:10
 */
public class NumUniqueEmails929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf("@");
            String local = email.substring(0,i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0,local.indexOf('+'));
            }
            local = local.replaceAll("\\.","");
            seen.add(local + rest);
        }
        return seen.size();
     }
}
