export const zkFetch = function(zkapi, command, args, resultCommand) {
  return new Promise((resolve, reject) => {
    const handleResponse = function(data) {
      setTimeout(() => zkapi.binder.unAfter(resultCommand, handleResponse), 0);
      resolve(data);
    };
    zkapi.binder.command(command, args, { duplicateIgnore: true });
    const watchListener = {
      onSend: function() {
        zkapi.binder.after(resultCommand, handleResponse);
        zkapi.zWatch.unlisten({onSend: watchListener});
      }
    };
    zkapi.zWatch.listen({onSend: watchListener});
  });
};
