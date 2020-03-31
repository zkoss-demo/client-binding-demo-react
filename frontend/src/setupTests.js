import React from 'react';
import Enzyme, { shallow, render, mount } from 'enzyme';
import adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new adapter() });

/* Globals only for tests */
global.React = React;
global.shallow = shallow;
global.render = render;
global.mount = mount;

global.zkapi = {
  load: () => Promise.resolve([]),
  binder: {}
};

global.flushPromises = function() {
  return new Promise(resolve => setImmediate(resolve));
}

