package com.Carlos.spaceinvanders.Entities;


import java.util.Objects;

public class positionModel {

        private int x;
        private int y;
        public positionModel(int x, int y){ // Problema em por publico?
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
            com.Carlos.spaceinvanders.Entities.positionModel position = (com.Carlos.spaceinvanders.Entities.positionModel) o;
            return x == position.x && y == position.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

