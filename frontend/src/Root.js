import React from 'react';
import { Provider } from 'react-redux';

import store from './services/store';

const Root = ({ children, initialState = {}, zkapi }) => {
  return <Provider store={store(initialState, zkapi)}>{children}</Provider>
};

export default Root;
