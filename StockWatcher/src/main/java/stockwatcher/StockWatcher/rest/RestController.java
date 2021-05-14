package stockwatcher.StockWatcher.rest;

import org.springframework.web.bind.annotation.*;
import stockwatcher.StockWatcher.domain.StockPrice;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/stockwatcher")
public class RestController {
    public StockPrice[] prices = new StockPrice[] {new StockPrice("AMZN", 100, 0.3), new StockPrice("MSFT", 10, 0.5)};

    @CrossOrigin
    @GetMapping("/stockPrices")
    public StockPrice[] getPrices(@RequestParam(value="symbols") String[] symbols) {
        if(symbols.length > 0) {
            prices = new StockPrice[symbols.length];
            for(int i=0; i<symbols.length; i++) {
                prices[i] = new StockPrice(symbols[i], 100, 0.3);
            }
            return prices;
        }
        return prices; // default
    }
    @GetMapping("/{id}")
    public Integer hello(@PathVariable int id) {
        return ++id;
    }
}
