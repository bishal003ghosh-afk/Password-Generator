function generatePassword() {
    const length = document.getElementById('length').value || 12;
    const useUpper = document.getElementById('upper').checked;
    const useLower = document.getElementById('lower').checked;
    const useNumbers = document.getElementById('numbers').checked;
    const useSymbols = document.getElementById('symbols').checked;
  
    let chars = '';
    if (useUpper) chars += 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    if (useLower) chars += 'abcdefghijklmnopqrstuvwxyz';
    if (useNumbers) chars += '0123456789';
    if (useSymbols) chars += '!@#$%^&*()-_=+[]{};:,.<>?';
  
    if (chars.length === 0) {
      alert("Please select at least one option.");
      return;
    }
  
    let password = '';
    for (let i = 0; i < length; i++) {
      password += chars.charAt(Math.floor(Math.random() * chars.length));
    }
  
    document.getElementById('password').value = password;
  }
  
  function copyPassword() {
    const passField = document.getElementById('password');
    passField.select();
    document.execCommand('copy');
    alert("Password copied to clipboard!");
  }