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

  unAfter(name, event, callback) {
    let binder = getBinder(name);
    if (binder) {
      binder.unAfter(event, callback);
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

  init(name, command, event) {
    let binder = getBinder(name);
    if (binder) {
      return new Promise((resolve, reject) => {
        let fn = res => {
          this.unAfter(name, event, fn);
          resolve(res);
        };
        let result = this.after(name, event, fn);
        if (!result)
          reject(new Error('Binder not found'));
        this.command(name, command);
      })
    }
    return Promise.reject(new Error('Binder not found'));
  }
};
