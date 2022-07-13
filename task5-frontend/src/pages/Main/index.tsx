import { Card } from "../../components/Card";
import { Header } from "../../components/Header";

export function Main() {
  return (
    <>
    <Header />
    <main>
      <section id="vehicles">
        <div className="vehicle-container">
          <Card />
        </div>
      </section>
    </main>
    </>
  )
}