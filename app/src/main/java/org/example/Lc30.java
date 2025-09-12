package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc30 {

	private boolean judge(Map<String, Integer> tmp, Map<String, Integer> res) {
		for (String key: res.keySet()){
			if (res.get(key) == 0) continue;
			if (!tmp.containsKey(key)) return false;

			//System.out.println("judge="+key + ":" + res.get(key) + " " + tmp.get(key));
			if ((int)res.get(key) != (int)tmp.get(key)) {
				//System.out.println(res.get(key) == 5000);
				//System.out.println(tmp.get(key) == 5000);
				//System.out.println(tmp.get(key) == res.get(key));
				//System.out.println("fwfewfwe ---- fwfewgergwe");
				return false;
			}
		}
		return true;
	}
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();

		int wn = words.length;
		if (wn <= 0) return res;
		int wl = words[0].length();
		if (wl <= 0) return res;

		Map<String, Integer> wordM = new HashMap<>();
		for (String word: words) {
			if (!wordM.containsKey(word)) {
				wordM.put(word, 0);
			}
			wordM.put(word,wordM.get(word)+1);
		}



		List<Map<String, Integer>> tmp = new ArrayList<>();
		for (int i=0;i<wl && i + wn*wl <= s.length();i++) {
			System.out.println("join----");
			Map<String, Integer> mem = new HashMap<>();

			for (int j = 0;j < wn;j++) {
				String subStr = s.substring(i + wl*j, i+wl*(j+1));
				if (!mem.containsKey(subStr)) {
					mem.put(subStr, 0);
				}
				mem.put(subStr, mem.get(subStr) + 1);
			}

			if (judge(mem, wordM)) {
				System.out.println("--wfwef--- " + i);
				res.add(i);
			} else {
				System.out.println("--wfwef---www ");
			}
			tmp.add(mem);
		}


		for (int i = wl*wn; i+wl <= s.length();i++) {

			String newWord = s.substring(i, i + wl);
			String oldWord = s.substring(i-wl*wn, i-wl*wn+wl);

			Map<String, Integer> mem = tmp.get(i%wl);
			//System.out.println(oldWord);
			// System.out.println(i);
			//for (String key: mem.keySet()) System.out.print(" " + key + ":" + mem.get(key));
			//System.out.println(" ");
			mem.put(oldWord, mem.get(oldWord)-1);

			if (!mem.containsKey(newWord)) {
				mem.put(newWord, 0);
			}
			mem.put(newWord, mem.get(newWord) + 1);
			//for (String key: mem.keySet()) System.out.print(" " + key + ":" + mem.get(key));
			//System.out.println(" ---- end ---");
			if (judge(mem, wordM)) {
				//System.out.println("----i--- hit=" + i);
				res.add(i+wl - wl*wn);
			}
		}

		return res;
	}
}
