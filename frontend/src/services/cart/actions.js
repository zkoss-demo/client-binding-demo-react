import { LOAD_CART, ADD_PRODUCT, REMOVE_PRODUCT, CHANGE_PRODUCT_QUANTITY } from './actionTypes';

export const loadCart = products => ({
  type: LOAD_CART,
  payload: products
});

export const addProduct = product => ({
  type: ADD_PRODUCT,
  payload: product
});

export const removeProduct = product => ({
  type: REMOVE_PRODUCT,
  payload: product
});

export const changeProductQuantity = product => ({
  type: CHANGE_PRODUCT_QUANTITY,
  payload: product
});

export const submitCart = (cartProducts, total) => (dispatch, getState, { zkapi }) => {
  console.log("submitCart boooo");

  const products = {};
  cartProducts.forEach(p => (products[p.id] = p.quantity));

  zkapi.binder.command('placeOrder', {...total, products});
};

