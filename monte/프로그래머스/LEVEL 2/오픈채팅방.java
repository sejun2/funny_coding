import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> userTable = new HashMap<>();
        for (String cmd : record) {
            String action = cmd.split(" ")[0];
            switch (action) {
                case "Enter":
                case "Change":
                    String id = cmd.split(" ")[1];
                    String name = cmd.split(" ")[2];
                    userTable.put(id, name);
                    break;
                case "Leave":
                default:
                    break;
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (String cmd : record) {
            String action = cmd.split(" ")[0];
            String id = cmd.split(" ")[1];
            String name = userTable.get(id);

            StringBuilder message = new StringBuilder();
            if(action.equals("Change")){
                continue;
            }
            message.append(name)
                .append(action.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
            result.add(message.toString());
        }
        
        return result.toArray(String[]::new);
    }
}