package com.Carlos.spaceinvanders.model.models;


import java.util.Objects;

public class PositionModel implements Model {

        private int x;
        private int y;
        public PositionModel(int x, int y){ // Problema em por publico?
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
        public int getX() {
            return x;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getY() {
            return y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PositionModel position = (PositionModel) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

