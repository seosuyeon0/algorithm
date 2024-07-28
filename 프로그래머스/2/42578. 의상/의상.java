import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int combinations = 1;  // 조합의 수를 저장하는 변수

        HashMap<String, Integer> clothesCount = new HashMap<>();  // 각 종류별 의류의 개수를 저장하는 해시맵

        // 의류 배열을 순회
        for (String[] item : clothes) {
            String type = item[1];  // 의류의 종류를 가져옴

            // 해시맵에 이미 해당 종류가 있으면, 개수를 증가
            if (clothesCount.containsKey(type)) {
                clothesCount.replace(type, clothesCount.get(type) + 1);
            } else {
                // 없으면, 해당 종류를 해시맵에 추가하고 개수를 1로 설정
                clothesCount.put(type, 1);
            }
        }

        // 조합의 수 계산
        for (String key : clothesCount.keySet()) {
            combinations *= clothesCount.get(key) + 1;  // 각 종류별 (의류 수 + 1)을 곱함
        }

        return combinations - 1;  // 모든 종류의 의류를 하나도 안 입는 경우를 제외
    }
}