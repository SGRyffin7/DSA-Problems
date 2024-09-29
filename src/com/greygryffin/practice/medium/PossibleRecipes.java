package com.greygryffin.practice.medium;

import java.util.*;

/*
https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 */
public class PossibleRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String, Integer> recipeIngredientCountMap = new HashMap<>();
        Map<String, ArrayList<String>> ingredientRecipeMap = new HashMap<>();
        for (int i=0; i<recipes.length; i++) {
            recipeIngredientCountMap.put(recipes[i], ingredients.get(i).size());
            for(int j=0; j<ingredients.get(i).size(); j++) {
                if(ingredientRecipeMap.containsKey(ingredients.get(i).get(j)))
                    ingredientRecipeMap.get(ingredients.get(i).get(j)).add(recipes[i]);
                else {
                    ArrayList<String> newList = new ArrayList<>();
                    newList.add(recipes[i]);
                    ingredientRecipeMap.put(ingredients.get(i).get(j), newList);
                }
            }
        }

        Queue<String> q = new LinkedList<>(Arrays.stream(supplies).toList());

        Set<String> completedRecipes = new HashSet<>();

        while(!q.isEmpty()) {
            String ingredient = q.poll();
            List<String> possibleRecipes = ingredientRecipeMap.get(ingredient);
            if(possibleRecipes != null && !possibleRecipes.isEmpty())
                for (String recipe : possibleRecipes) {
                    int ingredientLeft = recipeIngredientCountMap.getOrDefault(recipe, 0);
                    if(ingredientLeft <= 1) {
                        completedRecipes.add(recipe);
                        q.offer(recipe);
                    } else
                        recipeIngredientCountMap.put(recipe, ingredientLeft-1);
                }
        }

        return new ArrayList<>(completedRecipes);
    }
}
