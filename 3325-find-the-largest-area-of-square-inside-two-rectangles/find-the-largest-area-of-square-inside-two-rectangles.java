class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long area = 0;
        int n = bottomLeft.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                    int x1 = bottomLeft[i][0], y1 = bottomLeft[i][1];
                    int x2 = topRight[i][0], y2 = topRight[i][1];
                    int x3 = bottomLeft[j][0], y3 = bottomLeft[j][1];
                    int x4 = topRight[j][0], y4 = topRight[j][1];

                    int left = Math.max(x1,x3);
                    int right = Math.min(x2,x4);
                    int bottom = Math.max(y1,y3);
                    int top = Math.min(y2,y4);

                    if(left <right && bottom < top){
                    int width = right - left;
                    int height = top - bottom;
                    int side = Math.min(width,height);
                    area = Math.max(area,1l * side*side);
                    }
            }
        }
        return area;
    }
}