import { EventEmitter } from 'events';

function getBinder(name) {
  return window.zkbind && window.zkbind.$(name);
}

export default {
  after(name, event, callback) {
    let binder = getBinder(name);
    if (binder) {
      binder.after(event, callback);
      return true;
    }
    return false;
  },

  command(name, event, args) {
    let binder = getBinder(name);
    if (binder) {
      binder.command(event, args);
      return true;
    }
    return false;
  },

  init(name, command, commandArguments, event) {
    this.init.emitters = this.init.emitters || {};
    let binder = getBinder(name);
    if (binder) {
      let emitter = this.init.emitters[event];
      if (!emitter) {
        this.init.emitters[event] = emitter = new EventEmitter();
        binder.after(event, data => { if (data) emitter.emit('data', data) });
      }
      return new Promise(resolve => {
        emitter.once('data', resolve);
        binder.command(command, commandArguments);
      });
    }
    return Promise.reject(new Error('Binder not found'));
  }
};
