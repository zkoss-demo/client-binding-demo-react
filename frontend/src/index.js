import 'babel-polyfill'
import React from 'react';
import ReactDOM from 'react-dom';

import App from './components/App';
import Root from './Root';
import {loadFromViewModel} from './util/zkBinder';

import './index.scss';

const { zk, zkbind } = window;
if (zk) {
  zk.afterMount(function () {
    const rootElement = document.getElementById('root');
    const binder = zkbind.$(rootElement);
    const load = (command, args, resultCommand) => loadFromViewModel(binder, command, args, resultCommand);
    const zkapi = {binder, load};
    ReactDOM.render(
      <Root zkapi = {zkapi}>
        <App />
      </Root>,
      rootElement
    );
  });
}
