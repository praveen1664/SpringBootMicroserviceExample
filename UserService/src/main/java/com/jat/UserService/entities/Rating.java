package com.jat.UserService.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Rating
{
private String userId;
private String hotelId;
private String ratingId;
private int rating;
private String feedback;


private Hotel hotel;
}
