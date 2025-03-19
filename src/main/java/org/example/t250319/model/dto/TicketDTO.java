package org.example.t250319.model.dto;

public record TicketDTO(
    String ticketId,
    String seatNumber,
    String price,
    String purchaseDate,
    String userId,
    String concertId

) {
}
