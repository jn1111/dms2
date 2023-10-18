package Service;

import Model.StockWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

@Service
@AllArgsConstructor
class StockService {
    public StockWrapper findStock(final String ticker) {
        try {
            return new StockWrapper(YahooFinance.get(ticker));
        } catch (IOException e) {

            System.out.println("Error");


        }
        return null;
    }

    public BigDecimal findPrice(final StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(true).getPrice();
    }

}
