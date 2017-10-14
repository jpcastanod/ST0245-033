public class EjercicioEnLinea {

public static int countEvens(int[] nums) {
  int cont = 0;
  for (int i = 0; i<nums.length;i++){
      if (nums[i]% 2 == 0){
     cont++;
     }
  }
  return cont;
}
public int bigDiff(int[] nums) {
  int max = nums[0];
  int min = nums[0];
  for (int i=0; i<nums.length; i++ )
  {
    if (max < nums[i]){
      max = nums[i];
    }
    else if ( min > nums[i]) {
     min = nums[i];
    }
  }
  return max-min;
}
public boolean no14(int[] nums) {
  int uno = 0;
  int cuatro = 0;
  for (int i = 0; i<nums.length; i++){
    if (nums[i] == 1){
    uno++;
    }
    else if (nums[i]==4){
    cuatro++;
    }
  }
  if ((uno!= 0 && cuatro == 0)|| (uno== 0 && cuatro != 0)|| (uno== 0 && cuatro == 0)){
  return true;
  }
  return false;
}
public int sum13(int[] nums) {
  int sum=0;
  for (int i = 0; i<nums.length; i++){
    if(nums[i]==13) {
      i++;
    }else{
    sum += nums[i];
    }
  }
  return sum; 
}
public boolean more14(int[] nums) {
  int uno = 0;
  int cuatro =0;
  for (int i = 0; i<nums.length; i++){
    if (nums[i] == 1){
      uno++;
    }
    else if (nums[i] == 4){
    cuatro ++;
    }
  }
  return uno>cuatro;
}

public int[] fix34(int[] nums) {
  int [] aux = new int [nums.length];
 for (int i = 0; i< nums.length; i++){
   if (nums [i] != 4){
   aux[i] = nums[i];
   }
   else if (nums [i] == 4 && nums[i-1] == 4){
     aux[i] =nums [i-2];
     }
   else {
     aux[i] = nums[i-1];
   }
   if (nums[i] == 3){
     for (int j= i; j<nums.length; j++){
       if (nums[j]== 4){
         i++;
         aux[i] = nums [j];
          break;
       }
     }
   }
 }
    return aux;
}
public boolean linearIn(int[] outer, int[] inner) {
    int posInner = 0;
    int posOuter = 0;
    while (posInner < inner.length && posOuter < outer.length) {
        if (outer[posOuter] == inner[posInner]) {
            posOuter++;
            posInner++;
        } else posOuter++;
    }
    return (posInner == inner.length);
}	
public int maxSpan(int[] nums) {
    if (nums.length > 0) {
        int max = 1;
        for (int i = 0; i < nums.length; i++)
            for (int j = nums.length - 1; j > i; j--)
                if (nums[j] == nums[i]) {
                    int count = (j - i) + 1;
                    if (count > max)
                    max = count;
                    break;
                }
        return max;
    } else return 0;
}
public boolean canBalance(int[] nums) {
    for (int i = 0; i < nums.length; i++) { 
        int sum = 0;
        for (int j = 0; j < i; j++) 
        sum += nums[j];
        for (int j = i; j < nums.length; j++)
        sum -= nums[j];
        if (sum == 0) return true;
    }
    return false;
}
public int[] fix45(int[] nums) {
    for (int i = 0; i < nums.length; i++)
        if (nums[i] == 5 && i == 0
            || nums[i] == 5 && nums[i - 1] != 4) {
            int pos5 = i;
            for (int j = 0; j < nums.length; j++)
                if (nums[j] == 4 && nums[j + 1] != 5) {
                    int temp = nums[j + 1];
                    nums[j + 1] = 5;
                    nums[pos5] = temp;
                    break;
                }
    }
    return nums;
}

}
