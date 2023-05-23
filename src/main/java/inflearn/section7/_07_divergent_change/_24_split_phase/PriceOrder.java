package inflearn.section7._07_divergent_change._24_split_phase;

/**
 * 단계 쪼개기
 * 서로 다른 일을 하는 코드를 각기 다른 모듈로 분리한다.
 *  그래야 어떤 것을 변경해야 할때, 그것과 관련있는 것만 신경쓸 수 있다.
 *  (사실상 이것도 함수 추출이라고 볼수있다.)
 */
public class PriceOrder {
    // before
//    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
//        final double basePrice = product.basePrice() * quantity;
//        final double discount = Math.max(quantity - product.discountThreshold(), 0)
//                * product.basePrice() * product.discountRate();
//        final double shippingPerCase = (basePrice > shippingMethod.discountThreshold()) ?
//                shippingMethod.discountedFee() : shippingMethod.feePerCase();
//        final double shippingCost = quantity * shippingPerCase;
//        final double price = basePrice - discount + shippingCost;
//        return price;
//    }

    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
        final PriceData priceData = calculatePriceData(product, quantity);
        return applyShipping(priceData,shippingMethod);
    }

    private static double applyShipping(PriceData priceData, ShippingMethod shippingMethod) {
        final double shippingPerCase = (priceData.basePrice() > shippingMethod.discountThreshold()) ?
                shippingMethod.discountedFee() : shippingMethod.feePerCase();
        final double shippingCost = priceData.quantity() * shippingPerCase;
        final double price = priceData.basePrice() - priceData.discount() + shippingCost;
        return price;
    }

    private static PriceData calculatePriceData(Product product, int quantity) {
        final double basePrice = product.basePrice() * quantity;
        final double discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate();
        // 중간데이터를 만들어서 사용하자. 왜냐 아래에 넘겨주는 변수가 너무 많음
        PriceData priceData = new PriceData(basePrice,discount, quantity);
        return priceData;
    }

}
