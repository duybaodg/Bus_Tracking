package com.example.api_with_header.objects;

import java.util.List;

public class Entity {
   private List<Bus> entity;

   public Entity(List<Bus> entity) {
      this.entity = entity;
   }

   public List<Bus> getEntity() {
      return entity;
   }

   public void setEntity(List<Bus> entity) {
      this.entity = entity;
   }

   @Override
   public String toString() {
      return "Entity{" +
              "entity=" + entity +
              '}';
   }
}
