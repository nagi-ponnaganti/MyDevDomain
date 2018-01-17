package com.nagihome.ej.ch02;

public class Item02 {

    public static void main(String[] args) {
        NutritionFacts facts = new NutritionFacts.Builder(240, 8).setCalories(200).build();
        System.out.printf("NutritionFacts: %s\n", facts.toString());
    }

    static class NutritionFacts {

        private final int servingSize;
        private final int servings;
        private final int calories;
        private final int fat;
        private final int sodium;
        private final int carbohydrate;

        @Override
        public String toString() {
            return "NutritionFacts{" +
                    "servingSize=" + servingSize +
                    ", servings=" + servings +
                    ", calories=" + calories +
                    ", fat=" + fat +
                    ", sodium=" + sodium +
                    ", carbohydrate=" + carbohydrate +
                    '}';
        }

        private NutritionFacts(Builder builder) {
            servingSize = builder.servingSize;
            servings = builder.servings;
            calories = builder.calories;
            fat = builder.fat;
            sodium = builder.sodium;
            carbohydrate = builder.carbohydrate;
        }

        static class Builder {

            private final int servingSize;
            private final int servings;
            private int calories = 0;
            private int fat = 0;
            private int sodium = 0;
            private int carbohydrate = 0;

            public Builder(int servingSize, int servings) {
                this.servingSize = servingSize;
                this.servings = servings;
            }

            public Builder setCalories(int val) {
                this.calories = val;
                return this;
            }

            public Builder setFat(int val) {
                this.fat = val;
                return this;
            }

            public Builder setSodium(int val) {
                this.sodium = val;
                return this;
            }

            public Builder setCarbohydrate(int val) {
                this.carbohydrate = val;
                return this;
            }

            public NutritionFacts build() {
                return new NutritionFacts(this);
            }

        }
    }

}
