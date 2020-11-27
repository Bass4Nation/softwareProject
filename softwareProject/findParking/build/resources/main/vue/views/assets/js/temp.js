window.onload = oppstart;

function oppstart() {
  document.getElementById("buyBtn").onclick = buyTrykk;
  document.getElementById("picBtn").onclick = mapTrykk;

  function buyTrykk() {
    alert('Du har bestillt plass.')
  }

  function mapTrykk() {
    alert('Bytter fra bilde, til kart')
  }
}
