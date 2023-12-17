class FoodRatings {
    public class Menu {
        String food, cuisine;
        int rating;
        public Menu (String food, String cuisine, int rating){
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    Map<String, PriorityQueue<Menu>> mapCuisine;
    Map<String, Menu> mapInfo;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        mapCuisine = new HashMap<>();
        mapInfo = new HashMap<>();
        for(int i=0;i<foods.length;i++){
            Menu obj = new Menu(foods[i], cuisines[i], ratings[i]);
            mapInfo.put(foods[i], obj);
            if(mapCuisine.containsKey(cuisines[i])){
                mapCuisine.get(cuisines[i]).add(obj);
            }
            else{
                PriorityQueue<Menu> pq = new PriorityQueue<Menu>(new Comparator<Menu>(){
                    @Override
                    public int compare(Menu a, Menu b){
                        int res = b.rating-a.rating;
                        if(res==0){
                            return (a.food).compareTo(b.food);
                        }
                        return res;
                    }
                });
                pq.add(obj);
                mapCuisine.put(cuisines[i],pq);
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        Menu prev = mapInfo.get(food);
        Menu curr = new Menu(food,prev.cuisine,newRating);
        mapInfo.put(food,curr);
        prev.food="";
        mapCuisine.get(prev.cuisine).add(curr);
    }
    
    public String highestRated(String cuisine) {
        while(mapCuisine.get(cuisine).peek().food.equals("")){
            mapCuisine.get(cuisine).remove();
        }
        return mapCuisine.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */