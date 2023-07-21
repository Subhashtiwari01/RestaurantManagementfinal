package com.RestaurantManagement.RestaurantManagement.Repo;

import com.RestaurantManagement.RestaurantManagement.Modal.RestaurantInformation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RestaurantRepo {

    private static List<RestaurantInformation> restaurentList=new ArrayList<>();


    public List<RestaurantInformation> getRestaurant() {

        return restaurentList;
    }

    public static RestaurantInformation getRestaurantById(String RestaurantId) {
        for(RestaurantInformation restaurantInformation:restaurentList){
            if(restaurantInformation.getRestaurantId().equals(RestaurantId)){
                return restaurantInformation;
            }
        }
        return null;

    }





}
