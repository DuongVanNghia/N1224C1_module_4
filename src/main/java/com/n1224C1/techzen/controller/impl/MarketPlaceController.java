//package com.n1224C1.techzen.controller.impl;
//
//import com.n1224C1.techzen.dto.ApiResponse;
//import com.n1224C1.techzen.exception.ApiException;
//import com.n1224C1.techzen.exception.Errorcode;
//import com.n1224C1.techzen.model.Employee;
//import com.n1224C1.techzen.model.MarketPlace;
//import com.n1224C1.techzen.model.Student;
//import com.n1224C1.techzen.service.impl.MarketPlaceService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("/marketplaces")
//public class MarketPlaceController {
//    private final MarketPlaceService marketPlaceService;
//    private List<MarketPlace> marketPlaces = new ArrayList<MarketPlace>(
//            Arrays.asList(
//                    new MarketPlace("MB001", "Van Phong 1", "123 duong ABC ,Da Nang",80,"van phong",3500000,LocalDate.of(2023, 10, 1)),
//                    new MarketPlace("MB002", "Cua hang A", "496 duong XYZ ,Da Nang",100,"cua hang",4000000,LocalDate.of(2023, 10, 15)),
//                    new MarketPlace("MB003", "Nha o 1", "789 duong Def ,Da Nang",160,"nha o",5500000,LocalDate.of(2023, 10, 20)),
//                    new MarketPlace("MB004", "Van Phong 2", "101 duong GHI ,Da Nang",60,"van phong",2200000,LocalDate.of(2023, 11, 5)),
//                    new MarketPlace("MB005", "Cua hang B", "202 duong KLM ,Da Nang",90,"cua hang",3800000,LocalDate.of(2023, 11, 10))
//
//
//
//            )
//    );
//
//    public MarketPlaceController(MarketPlaceService marketPlaceService) {
//        this.marketPlaceService = marketPlaceService;
//    }
//
//    @GetMapping
//    public List<MarketPlace> getMarketPlaces() {
//        return marketPlaces;
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<MarketPlace>> getMarketPlace(@PathVariable("id") String id) {
//        for (MarketPlace marketPlace : marketPlaces) {
//            if (marketPlace.getId() == id) {
//
//                return ResponseEntity.ok(ApiResponse.<MarketPlace>builder()
//                        .data(marketPlace)
//                        .build());
//            }
//        }
//        throw new ApiException(Errorcode.EMPLOYEE_NOT_EXIST);
//    }
//    @PostMapping
//    public ResponseEntity<?> addMarketPlace(@RequestBody MarketPlace marketPlace) {
//        return ResponseEntity.ok(ApiResponse.<MarketPlace>builder()
//                .data(MarketPlaceService.addMarketPlace(marketPlace))
//                .build());
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<MarketPlace>> updateMarketPlace(@PathVariable("id") String id, @RequestBody MarketPlace marketPlace) {
//        marketPlace.setId(id);
//        return ResponseEntity.ok(ApiResponse.<MarketPlace>builder()
//                .data(marketPlaceService.updateMarketPlace(marketPlace))
//                .build());
//
//
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteMarketPlace(@PathVariable("id") String id) {
//        MarketPlaceService.deleteMarketPlace(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//
//
//}
