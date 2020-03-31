const zWatch = window.zWatch;

export const loadFromViewModel = function(binder, command, args, resultCommand) {
  return new Promise((resolve, reject) => {
    const handleResponse = function(data) {
      setTimeout(() => binder.unAfter(resultCommand, handleResponse), 0);
      resolve(data);
    };
    binder.command(command, args, { duplicateIgnore: true });
    const watchListener = {
      onSend: function() {
        binder.after(resultCommand, handleResponse);
        zWatch.unlisten({onSend: watchListener});
      }
    };
    zWatch.listen({onSend: watchListener});
  });
};
