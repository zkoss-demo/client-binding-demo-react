package react.vm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.util.Notification;
import react.dto.ProductDto;
import react.service.ProductService;

import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

/**
 * @author rudyhuang
 */
@ToServerCommand({"loadProducts", "placeOrder"})
@ToClientCommand({"loadProductsDone"})
@VariableResolver(DelegatingVariableResolver.class)
public class IndexVM {
	private static final Logger LOG = LoggerFactory.getLogger(IndexVM.class);

	@WireVariable
	private ProductService productService;

	private Map<String, Integer> cartProducts;

	@Command
	public void loadProducts(
			@ContextParam(ContextType.BINDER) Binder binder,
			@BindingParam("filterSizes") List<String> filterSizes) {
		List<ProductDto> products = filterSizes == null || filterSizes.isEmpty()
				? productService.getProducts()
				: productService.getProductsFilterByAvailableSizes(filterSizes);

		binder.postCommand("loadProductsDone", Collections.singletonMap("data", products));
	}

	@Command
	public void loadProductsDone() { /* dummy */ }

	@Command
	public void placeOrder(
			@ContextParam(ContextType.BINDER) Binder binder,
			@BindingParam("currencyFormat") String format,
			@BindingParam("totalPrice") double price,
			@BindingParam("currencyId") String id,
			@BindingParam("products") Map<String, Integer> products) {

		if (products.isEmpty()) {
			Notification.show("Add some products in the cart!", Notification.TYPE_ERROR, null, null, 5000, true);
			return;
		}

		Notification.show(String.format("Checkout - Subtotal: %s %.2f", format, price));
		this.cartProducts = products;
		this.cartProducts.forEach((p, q) -> LOG.info("Order Product#{}, Quantity: {}", p, q));
		// Save to DB and/or redirect to another zul page
		// or post a command back to react
	}
}
