package react.vm;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import react.dto.ProductDto;
import react.service.ProductService;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.NotifyCommand;
import org.zkoss.bind.annotation.NotifyCommands;
import org.zkoss.bind.annotation.ToClientCommand;
import org.zkoss.bind.annotation.ToServerCommand;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

/**
 * @author rudyhuang
 */
@NotifyCommands({
	@NotifyCommand(value = "getProducts", onChange = "_vm_.products")
})
@ToServerCommand({"tipProducts", "placeOrder"})
@ToClientCommand({"getProducts"})
@VariableResolver(DelegatingVariableResolver.class)
public class IndexVM {
	private static final Logger LOG = LoggerFactory.getLogger(IndexVM.class);

	@WireVariable
	private ProductService productService;

	private List<ProductDto> products;

	private Map<String, Integer> cartProducts;

	@Init
	public void init() {
		products = productService.getProducts();
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	@Command
	@NotifyChange("products")
	public void tipProducts() {
		// just triggering getProducts
	}

	@Command
	public void placeOrder(@BindingParam("format") String format,
	                       @BindingParam("price") double price,
	                       @BindingParam("id") String id,
	                       @BindingParam("products") Map<String, Integer> cartProducts) {
		Clients.showNotification(String.format("Checkout - Subtotal: %s %.2f", format, price));
		this.cartProducts = cartProducts;
		this.cartProducts.forEach((p, q) -> LOG.info("Order Product#{}, Quantity: {}", p, q));
		// Save to DB...
	}
}
