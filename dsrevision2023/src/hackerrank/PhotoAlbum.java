package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotoAlbum {


    static List<Integer> getArrangedAlbum(List<Integer> index,List<Integer> identity){
        Integer[] output = new Integer[identity.size()];

        for(int i=0;i<identity.size();i++){
          int opIndex = index.get(i);
          if(output[opIndex]==null){
              output[opIndex]=identity.get(i);
          }else{

              for(int j=output.length-1;j>=opIndex;j--){
                  if(output[j]!=null) {
                      output[j + 1] = output[j];
                  }
              }
              output[opIndex]=identity.get(i);
          }
        }
        return Arrays.asList(output);
    }

    public static void main(String[] args) {
       List<Integer> output = getArrangedAlbum(Arrays.asList(0,1,1),Arrays.asList(0,1,2));
        System.out.println(output);
    }
}
