package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lc22 {
    class Item{
        public int left = 0;
        public int right = 0;
        String res = "";
    }
    public List<String> generateParenthesis(int n) {
        List<Item> res = new ArrayList<>();
        List<Item> nItem = new ArrayList<>();
        res.add(new Item());

        for (int cnt=0;cnt<2*n;cnt++){

            for (Item item:res){
                if (item.left < item.right) continue;;

                if (item.left < n) {
                    Item nn = new Item();
                    nn.left = item.left+1;
                    nn.right = item.right;
                    nn.res = item.res + "(";
                    nItem.add(nn);
                }

                if (item.right < item.left && item.right < n) {

                    //item.left = item.left;
                    ++item.right;// = item.right+1;
                    item.res += ")";
                    nItem.add(item);
                }



            }
            res = nItem;
            nItem.clear();
        }


        List<String> realRes = new ArrayList<>();
        for (Item item:res){
            realRes.add(item.res);
        }
        return realRes;
    }
}
