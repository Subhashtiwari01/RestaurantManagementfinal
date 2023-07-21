package com.RestaurantManagement.RestaurantManagement.Service;

import com.RestaurantManagement.RestaurantManagement.Modal.RestaurantInformation;
import com.RestaurantManagement.RestaurantManagement.Repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RestaurantService {

    @Autowired

    RestaurantRepo restaurantRepo;

    public List<RestaurantInformation> getRestaurant() {
        return restaurantRepo.getRestaurant();
    }


    public String createrestaurant(List<RestaurantInformation> restaurantInformation) {
        List<RestaurantInformation>originalList=getRestaurant();
        originalList.addAll(restaurantInformation);
        return "New Restaurant Added";


    }

    public String createRestaurent(RestaurantInformation restaurantInformation) {
        List<RestaurantInformation> originalList=getRestaurant();
        originalList.add(restaurantInformation);
        return "RestaurantAdded";
    }

    public String updateRestaurant(String RestaurantId, RestaurantInformation restaurantInformation) {
        RestaurantInformation restaurent1=restaurantRepo.getRestaurantById(RestaurantId);


        if(restaurent1!=null){
            restaurent1.setName(restaurantInformation.getName());
            restaurent1.setNumber(restaurantInformation.getNumber());
            restaurent1.setAddress (restaurantInformation.getAddress());
            restaurent1.setSpeciality(restaurantInformation.getSpeciality());
            restaurent1.setTotalStaffs (restaurantInformation.getTotalStaffs());

        }
        return "Information Updated";

    }


    public String removerestaurantInformation(String RestaurantId) {
        List<RestaurantInformation> rest=restaurantRepo.getRestaurant();

        for(RestaurantInformation restaurantInformation:rest){
            if(restaurantInformation.getRestaurantId().equals(RestaurantId)){
                rest.remove(restaurantInformation);
                return"restaurant deleted";
            }
        }
        return "User with given id not found";

    }
}
