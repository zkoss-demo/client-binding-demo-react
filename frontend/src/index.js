import 'babel-polyfill'
import React from 'react';
import ReactDOM from 'react-dom';

import App from './components/App';
import Root from './Root';

import './index.scss';

const { zk, zkbind, zWatch } = window;
if (zk) {
  zk.afterMount(function () {
    const rootElement = document.getElementById('root');
    const binder = zkbind.$(rootElement);
    ReactDOM.render(
      <Root zkapi = {{ binder, zWatch }}>
        <App />
      </Root>,
      rootElement
    );
  });
}
