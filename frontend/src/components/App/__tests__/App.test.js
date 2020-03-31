import Root from '../../../Root';
import App from '../';

import Shelf from '../../Shelf';
import FloatCart from '../../FloatCart';

let wrapped;

zkapi.load = () => Promise.resolve([]);

beforeEach(() => {
  wrapped = mount(
    <Root zkapi={zkapi}>
      <App />
    </Root>
  );
});

afterEach(() => {
  wrapped.unmount();
});

it('shows a shelf', () => {
  expect(wrapped.find(Shelf).length).toEqual(1);
});

it('shows a floating cart', () => {
  expect(wrapped.find(FloatCart).length).toEqual(1);
});
